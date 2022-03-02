package com.kiryometsy.applicator.job.simple.utility;

import com.google.gson.Gson;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static io.netty.util.internal.ObjectUtil.checkNotNull;
import static java.lang.String.format;



public class JsonReader {

    public static String readJson(String pathToJson) {
        var reader = readJsonDefinition(pathToJson);
        return getAsString(reader);
    }

    public static <T> T readJsonDefinition(String pathToJson, Class<T> typeOfT) {
        var reader = readJsonDefinition(pathToJson);
        var jsonAsString = getAsString(reader);
        return new Gson().fromJson(jsonAsString, typeOfT);
    }

    private static BufferedReader readJsonDefinition(String pathToJson) {
        var inputStream = JsonReader.class.getResourceAsStream(pathToJson);
        checkNotNull(inputStream, format("No file found for the path %s", pathToJson));
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    @SneakyThrows(IOException.class)
    private static String getAsString(BufferedReader reader) {
        return IOUtils.toString(reader);
    }

}
