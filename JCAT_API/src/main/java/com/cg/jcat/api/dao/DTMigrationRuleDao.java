	package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.DTMigration;
import com.cg.jcat.api.entity.DTMigrationRule;
import com.cg.jcat.api.entity.DTMigrationRuleHistory;
import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.repository.IDTMigrationRepository;
import com.cg.jcat.api.repository.IDTMigrationRuleHistoryRepository;
import com.cg.jcat.api.repository.IDTMigrationRuleRepository;

@Component
public class DTMigrationRuleDao {
	
	@Autowired
	IDTMigrationRuleRepository dtMigrationRuleRepository;
	
	@Autowired
	IDTMigrationRepository dtMigrationRepository;
	
	@Autowired
	IDTMigrationRuleHistoryRepository dtMigrationRuleHistoryRepository;
	
	public List<DTMigrationRuleModel> getMigrationRule(){
		List<DTMigrationRuleModel> dtMigrationRuleModelIST=new ArrayList<DTMigrationRuleModel>();
		List<DTMigrationRule> dtMigrationRuleLIST=toGetMigrationRule();
		return toGetMigrationRule(dtMigrationRuleLIST,dtMigrationRuleModelIST);
	}
	
	public List<DTMigrationRuleModel> toGetMigrationRule(List<DTMigrationRule> dtMigrationRuleLIST,List<DTMigrationRuleModel> dtMigrationRuleModelIST){
		
		for(DTMigrationRule assessmentQuestion:dtMigrationRuleLIST)
		{
			dtMigrationRuleModelIST.add(toGetMigrationRuleModel(assessmentQuestion));
		}
		return dtMigrationRuleModelIST;
	}
	
	public List<DTMigrationRule> toGetMigrationRule()
	{
		return dtMigrationRuleRepository.findAll();
	}
	

	public boolean saveDTMigrationRule(List<DTMigrationRuleModel> dtMigrationRuleModelList) throws SystemExceptions {
		int countOfHistoryRule = getCountOfMigrationRuleHistoryRule();
		System.out.println(countOfHistoryRule);
		if(countOfHistoryRule != 0 || getCountOfMigrationRule()!=0)
		{
			saveMigrationRuleHistory(toGetMigrationRule());
		}
		dtMigrationRuleRepository.deleteAll();
		saveAllMigrationRule(dtMigrationRuleModelList);
		return true;
	}
	
	public int getCountOfMigrationRuleHistoryRule() throws SystemExceptions
	{
		int count = 0;
		try {
			count = dtMigrationRuleHistoryRepository.findAll().size();
		} catch (Exception e) {
			throw new SystemExceptions("getCountOfMigrationRuleHistoryRule()");
		}
		
		return count;
	}
	
	public int getCountOfMigrationRule()
	{
		return dtMigrationRuleRepository.findAll().size();
	}
	
	public void saveAllMigrationRule(List<DTMigrationRuleModel> dtMigrationRuleModelList)
	{
		for(DTMigrationRuleModel dtMigrationRuleModel : dtMigrationRuleModelList)
		{
			dtMigrationRuleRepository.save(toGetMigrationRule(dtMigrationRuleModel));
		}
		
	}
	
	public boolean updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
		boolean updateResult = false;
		updateResult = dtMigrationRuleRepository.saveAndFlush(toGetMigrationRule(dtMigrationRuleModel)) != null;
		System.out.println(updateResult);
		return updateResult;
	}
	
	
	
	
	/*
	 * MIGRATION PATTERN
	 * */
	
	public List<DTMigrationModel> getMigrationPattern(){
		List<DTMigrationModel> dtMigrationModelIST=new ArrayList<DTMigrationModel>();
		List<DTMigration> dtMigrationLIST=dtMigrationRepository.findAll();
		return toGetMigration(dtMigrationLIST,dtMigrationModelIST);
	}
	
	public List<DTMigrationModel> toGetMigration(List<DTMigration> dtMigrationLIST,List<DTMigrationModel> dtMigrationModelIST){
		
		for(DTMigration assessmentQuestion:dtMigrationLIST)
		{
			dtMigrationModelIST.add(toGetDTMigration(assessmentQuestion));
		}
		return dtMigrationModelIST;
	}
	
	
	/*
	 * Migration Rule History Getter
	 * */
	
	public void saveMigrationRuleHistory(List<DTMigrationRule> dtMigrationRuleList)
	{
		for(DTMigrationRule dtMigrationRule : dtMigrationRuleList)
		{
			dtMigrationRuleHistoryRepository.save(toGetMigrationRuleHistory(dtMigrationRule));
		}
	}
	
	public DTMigrationRuleHistory toGetMigrationRuleHistory(DTMigrationRule dtMigrationRule)
	{
		Date date = new Date();
		DTMigrationRuleHistory dtMigrationRuleHistory = new DTMigrationRuleHistory();
		dtMigrationRuleHistory.setCreatedBy( "Admin" );
		dtMigrationRuleHistory.setCreatedTime(date);
		dtMigrationRuleHistory.setExecutionOrder( dtMigrationRule.getEvaluationOrder() );
		dtMigrationRuleHistory.setMigrationId( dtMigrationRule.getMigrationId());
		dtMigrationRuleHistory.setMigrationRuleId( dtMigrationRule.getMigrationRuleId() );
		dtMigrationRuleHistory.setQuestionId( dtMigrationRule.getQuestionId() );
		dtMigrationRuleHistory.setQuestionTextEN( dtMigrationRule.getQuestiontextEN() );
		dtMigrationRuleHistory.setRuleOptionIds( dtMigrationRule.getRuleOptionIds() );
		dtMigrationRuleHistory.setRuleOptionTextEN( dtMigrationRule.getRuleOptionTextEN() );
		return dtMigrationRuleHistory;
	}
	
	
	/*
	 * Migration Rule Model Getter
	 * */
	
	public DTMigrationRuleModel toGetMigrationRuleModel(DTMigrationRule dtMigrationRule)
	{
		DTMigrationRuleModel dtMigrationRuleModel = new DTMigrationRuleModel();
		dtMigrationRuleModel.setEvaluationOrder(dtMigrationRule.getEvaluationOrder());
		dtMigrationRuleModel.setMigrationId(dtMigrationRule.getMigrationId());
		dtMigrationRuleModel.setMigrationRuleId(dtMigrationRule.getMigrationRuleId());
		dtMigrationRuleModel.setQuestionId(dtMigrationRule.getQuestionId());
		dtMigrationRuleModel.setQuestiontextEN(dtMigrationRule.getRuleOptionTextEN());
		dtMigrationRuleModel.setRuleOptionIds(dtMigrationRule.getRuleOptionIds());
		dtMigrationRuleModel.setRuleOptionTextEN(dtMigrationRule.getRuleOptionTextEN());
		return dtMigrationRuleModel;
	}

	/*
	 * Migration Rule Getter
	 * */
	
	public DTMigrationRule toGetMigrationRule(DTMigrationRuleModel dtMigrationRuleModel)
	{
		Date date=new Date();
		System.out.println(dtMigrationRuleModel);
		DTMigrationRule dtMigrationRule = new DTMigrationRule();
		dtMigrationRule.setEvaluationOrder(dtMigrationRuleModel.getEvaluationOrder());
		dtMigrationRule.setMigrationId(dtMigrationRuleModel.getMigrationId());
		dtMigrationRule.setMigrationRuleId(dtMigrationRuleModel.getMigrationRuleId());
		dtMigrationRule.setQuestionId(dtMigrationRuleModel.getQuestionId());
		dtMigrationRule.setQuestiontextEN(dtMigrationRuleModel.getQuestiontextEN());
		dtMigrationRule.setRuleOptionIds(dtMigrationRuleModel.getRuleOptionIds());
		dtMigrationRule.setRuleOptionTextEN(dtMigrationRuleModel.getRuleOptionTextEN());
		dtMigrationRule.setCreatedBy("Admin");
		dtMigrationRule.setCreatedTtime(date);
		return dtMigrationRule;
	}
	
	/*
	 * Migration Getter
	 * */
	
	public DTMigrationModel toGetDTMigration(DTMigration dtMigration)
	{
		DTMigrationModel dtMigrationModel = new DTMigrationModel();
		dtMigrationModel.setCreatedBy(dtMigration.getCreatedBy());
		dtMigrationModel.setCreatedTtime(dtMigration.getCreatedTtime());
		dtMigrationModel.setEvaluationOrder(dtMigration.getEvaluationOrder());
		dtMigrationModel.setLogicalOperator(dtMigration.getLogicalOperator());
		dtMigrationModel.setMigration_pattern(dtMigration.getMigration_pattern());
		dtMigrationModel.setMigrationId(dtMigration.getMigrationId());
		dtMigrationModel.setModifiedTime(dtMigration.getModified_time());
		dtMigrationModel.setModifiedBy(dtMigration.getModifiedBy());
		return dtMigrationModel;
	}
}


/*public boolean saveMigrationRule(DTMigrationRuleModel dtMigrationRuleModel) {
	try {
		return saveDTMigrationRule(dtMigrationRuleModel);
	}catch (Exception e) {
		System.out.print(ExceptionMessages.SaveUsersToDB + e);
		return false;
	}
}*/
