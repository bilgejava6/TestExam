package com.muhammet.service;

import com.muhammet.repository.IUserRepository;
import com.muhammet.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public User save(User user){
        /**
         * User Repository ye ait bir kod bu nedenle repo da oluşacak bir hata sizide etkiler
         */
        Optional<User> optionalUser = userRepository.findOptionalByAd(user.getAd());
        if(optionalUser.isPresent())
            throw new RuntimeException("Bu isimde bir kullanıcı zaten var");
        else if(user.getAd()==null)
            throw new RuntimeException("Kullanıcı adı boş olamaz");
      return  userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

}
