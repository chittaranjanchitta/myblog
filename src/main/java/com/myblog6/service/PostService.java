package com.myblog6.service;

import com.myblog6.payload.PostDto;
import com.myblog6.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getPosts(int pageNo, int pageSize, int sortBy);

    List<PostDto> getPosts(int pageNo, int pageSize, String sortBy);


   PostResponse getPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
