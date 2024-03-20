package com.litres.bookstore.controller;

import com.litres.bookstore.dto.AuthorDTO;
import com.litres.bookstore.dto.ReaderDTO;
import com.litres.bookstore.mapper.UserMapper;
import com.litres.bookstore.service.AuthorService;
import com.litres.bookstore.service.ReaderService;
import com.litres.bookstore.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST APIs for Registration",
        description = "REST APIs - Registration Author, Registration Reader"
)
@RestController
class RegistrationController {

    private final UserServiceImpl userService;

    private final AuthorService authorService;

    private final ReaderService readerService;

    private final UserMapper userMapper;

    public RegistrationController(UserServiceImpl userService, AuthorService authorService, ReaderService readerService, UserMapper userMapper) {
        this.userService = userService;
        this.authorService = authorService;
        this.readerService = readerService;
        this.userMapper = userMapper;
    }

    @Operation(
            summary = "Create Author"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/api/authors/registration")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author) {
        if (!userService.saveUser(userMapper.mapToUser(author))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Create Reader"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/api/readers/registration")
    public ResponseEntity<ReaderDTO> createReader(@RequestBody ReaderDTO reader) {
        if (!userService.saveUser(userMapper.mapToUser(reader))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(readerService.createReader(reader), HttpStatus.CREATED);
    }

}