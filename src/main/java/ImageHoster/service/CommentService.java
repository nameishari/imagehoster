package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Saves the comment.
     */
    public void saveComment(Image image, String commentText) {
        Comment newComment = new Comment();
        newComment.setUser(image.getUser());
        newComment.setCreatedDate(LocalDate.now());
        newComment.setImage(image);
        newComment.setText(commentText);
        commentRepository.saveComment(newComment);
    }
}
