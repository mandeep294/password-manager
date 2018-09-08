package com.mandeep.secure.web.rest;

import com.mandeep.secure.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mandeep.secure.service.GeneratorService;
import com.mandeep.secure.util.AppConstants;

@RestController
@RequestMapping(value = AppConstants.BASE_URI)
public class PassManagerResource implements AppConstants {

	@Autowired
	private PassService passService;
	
	@RequestMapping(value = "/generate/{siteName}/{userName}", method = RequestMethod.GET)
	public String generate(@PathVariable(name = "siteName") String siteName,
			@PathVariable(name = "userName") String userName) {
		passService.generateAndSave(siteName, userName);
		return "Success";
	}


	@RequestMapping(value = "/fetch/{siteName}/{userName}", method = RequestMethod.GET)
	public String getPassword(@PathVariable(name = "siteName") String siteName,
						   @PathVariable(name = "userName") String userName) {

		return passService.fetch(siteName, userName);
	}

}
