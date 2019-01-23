package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.DTMigrationModel;
import com.cg.jcat.api.dao.DTMigrationRuleModel;
import com.cg.jcat.api.dao.UserModel;
import com.cg.jcat.api.entity.DTMigration;

@RestController
@RequestMapping("/migration")
public interface IDTMigrationRuleController {
	
	@GetMapping("/get/rule")
	public List<DTMigrationRuleModel> getMigrationRule();
	
	@PostMapping("/create/rule")
	public void saveMigrationRule(@RequestBody List<DTMigrationRuleModel> dtMigrationRuleModel);
	
	@PutMapping("/update")
	public void updateMigrationRule(DTMigrationRuleModel dtMigrationRuleModel);
	
	@GetMapping("/get/pattern")
	public List<DTMigrationModel> getMigration();

}
