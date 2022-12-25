package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class travelController {
	
	@Autowired travel_repo ob;

	@PostMapping("/addTravel")
	public String saveTravel(@RequestBody Travel travel)
	{
	Travel a= new Travel();
	
	int id= travel.getTravelid();
	String name =travel.getName();
	String des= travel.getDescription();
	
	a.setTravelid(id);
	a.setName(name);
	a.setDescription(des);
	
	
	Travel first = new Travel(id,name,des);
	ob.save(first);
	
return "Added successfully";

	}
	
	@GetMapping("/travel")
    public List<Travel> getAllTravelList()
    {

        return ob.findAll();

    }
    
    @GetMapping("travel/{id}")
    public List<Travel> getSingleTravel(@PathVariable("id") int id){
    

    	return ob.findById(id);

        
    }
    
    @PutMapping("/update/{id}")
	public String update(@RequestBody Travel T,@PathVariable("id") int id)
    {
		
	 	 
		int id1= T.getTravelid();
		String name =T.getName();
		String description= T.getDescription();
		
		ob.update(id1,name,description,id);
			 
		return "successfully updated";
}

	
	@DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
	 
		ob.deleteAllByIdInBatch(id);
		
		return "deleted successfully";
}

    

}
