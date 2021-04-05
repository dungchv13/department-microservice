package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User findById(Long id) {

        return userRepository.findById(id).get();
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = findById(id);
        Department department = restTemplate.getForObject("http://localhost:8081/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
