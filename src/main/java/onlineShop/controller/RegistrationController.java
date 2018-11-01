package onlineShop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import onlineShop.model.Customer;
import onlineShop.service.CustomerService;

@Controller
public class RegistrationController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/registration", method = RequestMethod.GET)
	public ModelAndView getRegisrationForm() {
		return new ModelAndView("register", "customer", new Customer());
	}
	
	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public ModelAndView registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		customerService.addCustomer(customer);
		modelAndView.addObject("registrationSuccess", "Register Successfully");
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
