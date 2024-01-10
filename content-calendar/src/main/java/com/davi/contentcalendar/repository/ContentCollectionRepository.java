package com.davi.contentcalendar.repository;

import com.davi.contentcalendar.model.Content;
import com.davi.contentcalendar.model.Status;
import com.davi.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){
    }

    public List<Content> findAll(){
        contentList.sort(Comparator.comparingInt(Content::id));
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));

        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    @PostConstruct
    public void init(){
        Content content = new Content(
                1,
                "First youtube video",
                "It just exists",
                Status.IN_PROGRESS,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                ""
        );

        Content content1 = new Content(
                2,
                "Second youtube video",
                "Same",
                Status.IDEA,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(content);
        contentList.add(content1);

    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
