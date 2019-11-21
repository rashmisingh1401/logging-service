package ibm.com.cloud.logging.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ibm.com.cloud.logging.model.Logging;

public class LoggingRepository {

	private List<Logging> events = new ArrayList<>();
	
	public Logging add(Logging event) {
		event.setId((long) (events.size()+1));
		events.add(event);
		
		return event;
	}
	
	public Logging findByName(String name) {
		Optional<Logging> event = events.stream().filter(a -> a.getName().equals(name)).findFirst();
		if (event.isPresent())
			return event.get();
		else
			return null;
	}
	
	public List<Logging> findAll() {
		return events;
	}
	
	/*
	 * public List<Event> findByDepartment(Long departmentId) { return
	 * events.stream().filter(a ->
	 * a.getDepartmentId().equals(departmentId)).collect(Collectors.toList()); }
	 */
	
	/*
	 * public List<Event> findByOrganization(Long organizationId) { return
	 * events.stream().filter(a ->
	 * a.getOrganizationId().equals(organizationId)).collect(Collectors.toList()); }
	 */
	
}
