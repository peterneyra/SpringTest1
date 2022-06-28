package com.demogis.app.view.json;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component("list.json")
public class UserListJsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		model.remove("title"); 
		return super.filterModel(model);
	}
	
	

}
