package de.ztronics.springexample.service;

import de.ztronics.springexample.model.User;
import de.ztronics.springexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Abrufen aller Benutzer
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Speichern eines neuen Benutzers
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Abrufen eines Benutzers anhand der ID
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Aktualisieren eines vorhandenen Benutzers
    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new RuntimeException("User must have an id to update");
        }
        return userRepository.save(user);
    }

    // Löschen eines Benutzers
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
