package ibm.com.cloud.logging.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.com.cloud.logging.model.Logging;
import ibm.com.cloud.logging.repository.LoggingRepository;

@RestController
public class LoggingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);
	
	@Autowired
	LoggingRepository repository;
	
	@PostMapping("/")
	public Logging add(@RequestBody Logging event) {
		LOGGER.info("Event add: {}", event);
		return repository.add(event);
	}
	
	@GetMapping("/{name}")
	public Logging findByName(@PathVariable("name") String name) {
		LOGGER.info("User find: name={}", name);
		return repository.findByName(name);
	}
	
	@GetMapping("/")
	public List<Logging> findAll() {
		LOGGER.info("Users find");
		return repository.findAll();
	}
	/*
	 * @GetMapping("/department/{departmentId}") public List<Event>
	 * findByDepartment(@PathVariable("departmentId") Long departmentId) {
	 * LOGGER.info("Employee find: departmentId={}", departmentId); return
	 * repository.findByDepartment(departmentId); }
	 * 
	 * @GetMapping("/organization/{organizationId}") public List<Event>
	 * findByOrganization(@PathVariable("organizationId") Long organizationId) {
	 * LOGGER.info("Employee find: organizationId={}", organizationId); return
	 * repository.findByOrganization(organizationId); }
	 */
}
