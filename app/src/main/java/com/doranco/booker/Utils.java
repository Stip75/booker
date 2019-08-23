package com.doranco.booker;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Book> feedBooks(Context context) {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.books);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Book>();
    }
}
