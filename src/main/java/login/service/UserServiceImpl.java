package login.service;

import java.util.HashSet;
import login.model.User;
import login.repository.RoleRepository;
import login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    @SuppressWarnings("unchecked")
    public void save(User user) {
        
        user.setPassword(user.getPassword());
        user.setRoles(new HashSet(roleRepository.findAll()));
        userRepository.save(user);
    }
    
    public User findByUsername(String username) {
        
        return userRepository.findByUsername(username);
    }
}
