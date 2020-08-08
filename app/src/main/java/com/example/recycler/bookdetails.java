package com.example.recycler;

import java.io.Serializable;
public class bookdetails implements Serializable{
    public String firstName,lastName,Genre,bookName,imageName,largeImage;
    public bookdetails(String firstName,String lastName,String Genre,String bookName,String imageName,String largeImage)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.Genre=Genre;
        this.bookName=bookName;
        this.imageName=imageName;
        this.largeImage=largeImage;

    }

}
