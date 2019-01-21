package com.cg.jcat.api.dao;

public class DTMigrationRuleModel {

	private int migrationRuleId;
	private int migrationId;
	private int evaluationOrder;
	private int questionId;
	private String questiontextEN;
	private int ruleOptionIds;
	private String ruleOptionTextEN;
	
	public int getMigrationRuleId() {
		return migrationRuleId;
	}
	public void setMigrationRuleId(int migrationRuleId) {
		this.migrationRuleId = migrationRuleId;
	}
	public int getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(int migrationId) {
		this.migrationId = migrationId;
	}
	public int getEvaluationOrder() {
		return evaluationOrder;
	}
	public void setEvaluationOrder(int evaluationOrder) {
		this.evaluationOrder = evaluationOrder;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestiontextEN() {
		return questiontextEN;
	}
	public void setQuestiontextEN(String questiontextEN) {
		this.questiontextEN = questiontextEN;
	}
	public int getRuleOptionIds() {
		return ruleOptionIds;
	}
	public void setRuleOptionIds(int ruleOptionIds) {
		this.ruleOptionIds = ruleOptionIds;
	}
	public String getRuleOptionTextEN() {
		return ruleOptionTextEN;
	}
	public void setRuleOptionTextEN(String ruleOptionTextEN) {
		this.ruleOptionTextEN = ruleOptionTextEN;
	}
	@Override
	public String toString() {
		return "DTMigrationRuleModel [migrationRuleId=" + migrationRuleId + ", migrationId=" + migrationId
				+ ", evaluationOrder=" + evaluationOrder + ", questionId=" + questionId + ", questiontextEN="
				+ questiontextEN + ", ruleOptionIds=" + ruleOptionIds + ", ruleOptionTextEN=" + ruleOptionTextEN + "]";
	}
	
}