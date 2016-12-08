package com.company.check;

import com.company.assets.Article;
import com.company.assets.Image;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoJavaCheck {
    public static void main(String[] args) {
        Article article = Article.newBuilder()
                .setTitle("TITLE")
                .setPrintData(
                        Article.PrintData.newBuilder()
                                .setPage(1)
                                .setSection("NEWS")
                )
                .build();

        byte[] bytes = article.toByteArray();

        try {
            Image image = Image.parseFrom(bytes);

            System.out.println("Caption: " + image.getCaption()); // Output: TITLE (same field type, ok)
            System.out.println("Author: " + image.getAuthor()); // Output: NEWS (why?)
            System.out.println("Width: " + image.getWidth()); // Output: 0 (default)

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}