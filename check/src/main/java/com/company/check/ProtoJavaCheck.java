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
                                .setIsPublished(true)
                                .setSection("NEWS")
                                .setColumn("Review")
                )
                .setKicker("BOOM")
                .build();

        byte[] bytes = article.toByteArray();

        try {
            Image image = Image.parseFrom(bytes);

            System.out.println("Caption: " + image.getCaption()); // TITLE
            System.out.println("Author: " + image.getAuthor()); // NEWS" Review
            System.out.println("Width: " + image.getWidth()); // 0

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}