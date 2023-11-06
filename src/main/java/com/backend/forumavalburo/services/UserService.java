package com.backend.forumavalburo.services;

import com.backend.forumavalburo.models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${storage}")
    private String storageFiles;
    
    public UserModel saveUser(UserModel newUser) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonModel = objectMapper.writeValueAsString(newUser);
            File newJson = new File(storageFiles);
            if(!newJson.exists()){
                newJson.mkdirs();
            }
            File usersJson = new File(storageFiles+"users.json");
            if(!usersJson.exists()){
                Files.createFile(Paths.get(storageFiles+"users.json"));
            }
            List<String> usersSaved = Files.readAllLines(Paths.get(storageFiles+"users.json"));
            usersSaved.add(jsonModel);
            Files.write(Paths.get(storageFiles+"users.json"), usersSaved);
        } catch (Exception e) {
            System.out.println("Error creating file = " + e.getMessage());
        }
        return newUser;
    }

}
