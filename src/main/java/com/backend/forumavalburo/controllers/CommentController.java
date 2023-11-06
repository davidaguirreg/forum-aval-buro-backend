
package com.backend.forumavalburo.controllers;

import com.backend.forumavalburo.models.CommentModel;
import com.backend.forumavalburo.services.CommentService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;
    
    @PostMapping()
    public ArrayList<CommentModel> updateComments(@RequestBody ArrayList<CommentModel> commentsUpdated){
        return this.commentService.saveComments(commentsUpdated);
    }
    
    @GetMapping()
    public ArrayList<CommentModel> getAllComments(){
        return this.commentService.getComments();
    }
}
