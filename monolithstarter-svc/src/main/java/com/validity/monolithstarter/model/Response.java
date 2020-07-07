package com.validity.monolithstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Response {
    List<User> duplicates = new ArrayList<>();
    List<User> clean = new ArrayList<>();

    public Response(List<User> duplicates, List<User> clean) {
        this.duplicates = duplicates;
        this.clean = clean;
    }

    public List<User> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(List<User> duplicates) {
        this.duplicates = duplicates;
    }

    public List<User> getClean() {
        return clean;
    }

    public void setClean(List<User> clean) {
        this.clean = clean;
    }
}
