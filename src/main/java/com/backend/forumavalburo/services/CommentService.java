
package com.backend.forumavalburo.services;

import com.backend.forumavalburo.models.CommentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Value("${storage}")
    private String storageFiles;
    
        public ArrayList<CommentModel> saveComments(ArrayList<CommentModel> commentsUpdated){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonModel = objectMapper.writeValueAsString(commentsUpdated);
            File newJson = new File(storageFiles);
            if(!newJson.exists()){
                newJson.mkdirs();
            }
            File commentsJson = new File(storageFiles+"comments.json");
            if(!commentsJson.exists()){
                Files.createFile(Paths.get(storageFiles+"comments.json"));
            }
            ArrayList<CommentModel> commentsSaved = this.getComments();
            commentsSaved = commentsUpdated;
            objectMapper.writeValue(commentsJson, commentsSaved);
        } catch (Exception e) {
            System.out.println("Error creating file = " + e.getMessage());
        }
        return commentsUpdated;
    }
    
    public ArrayList<CommentModel> getComments(){
        ArrayList<CommentModel> commentsSaved = new ArrayList<CommentModel>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File commentsJson = new File(storageFiles+"comments.json");
            if(!commentsJson.exists()){
                Files.createFile(Paths.get(storageFiles+"comments.json"));
            }
            commentsSaved = objectMapper.readValue(commentsJson,
                    objectMapper.getTypeFactory()
                            .constructCollectionType(ArrayList.class, CommentModel.class));
            
            
        } catch (Exception e) {
            System.out.println("Error creating file = " + e.getMessage());
        }
        return commentsSaved;
    } 
}
