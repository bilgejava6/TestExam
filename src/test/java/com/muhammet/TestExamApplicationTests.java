package com.muhammet;

import com.muhammet.repository.entity.User;
import com.muhammet.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestExamApplicationTests {

	@Autowired
	private UserService userService;
	/**
	 * 1. Test DAha önce kayıt olmamış ve geçerli bir adı olan kullanıcı için
	 * test işlemi
	 */
	@Test
	void saveTestForAcceptableUser() {
		User user = new User();
		user.setAd("Muhammet");
		user.setAdres("Ankara");
		/**
		 * Eğer kayıt başarılı olursa hata fırlatmaz ve user içinde id değeri olur
		 */
		userService.save(user);
		userService.getAll().forEach(System.out::println);
		Assertions.assertNotNull(user.getId());
	}

}
