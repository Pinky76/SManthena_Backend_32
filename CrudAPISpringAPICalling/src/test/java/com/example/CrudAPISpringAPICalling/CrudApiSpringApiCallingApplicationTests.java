package com.example.CrudAPISpringAPICalling;

import com.example.CrudAPISpringAPICalling.Controller.UserDetails;
import com.example.CrudAPISpringAPICalling.Resource.ResourceAPI;
import com.example.CrudAPISpringAPICalling.Service.ServiceAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CrudApiSpringApiCallingApplicationTests {


	private ResourceAPI resourceAPI;
	private List<UserDetails> dataList;

	@BeforeEach
	public void setUp() {
		dataList = new ArrayList<>();
		resourceAPI = new ResourceAPI(new ServiceAPI(dataList));
	}

	@Test
	public void testGetAllData() {
		List<UserDetails> result = resourceAPI.getAllData();
		Assertions.assertEquals(dataList, result);
	}

	@Test
	public void testGetData() {
		UserDetails userDetails = new UserDetails("manasa", "01-01-2022", "Prem","teksystems", "mani",90,"java");
		dataList.add(userDetails);

		List<UserDetails> result = resourceAPI.getData("teksystems");
		Assertions.assertEquals(List.of(userDetails), result);
	}

	@Test
	public void testAddData() {
		UserDetails userDetails = new UserDetails("Sai", "01-01-2022", "Prem","teksystems", "mani",90,"java");
		resourceAPI.addData(userDetails);

		Assertions.assertEquals(List.of(userDetails), dataList);
	}

	@Test
	public void testDeleteData() {
		UserDetails userDetails = new UserDetails("SaiM", "01-01-2022", "Prem","teksystems", "mani",90,"java");
		dataList.add(userDetails);

		resourceAPI.deleteData(0);

		Assertions.assertTrue(dataList.isEmpty());
	}

	@Test
	public void testUpdateData() {
		UserDetails userDetails = new UserDetails("Manu", "01-01-2022", "Prem","teksystems", "mani",90,"java");
		dataList.add(userDetails);

		UserDetails updatedUserDetails = new UserDetails("manasa", "01-02-2022", "sagar","teksystems", "mani",90,"java");
		resourceAPI.updateData(0, updatedUserDetails);

		Assertions.assertEquals(updatedUserDetails, dataList.get(0));
	}
}
