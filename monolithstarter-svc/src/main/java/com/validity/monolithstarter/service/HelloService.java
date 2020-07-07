package com.validity.monolithstarter.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.validity.monolithstarter.model.Response;
import com.validity.monolithstarter.model.User;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {
    public String getHelloMessage() {
        return "Hello from the server!";
    }

    public List<User> readCsv() {
        File file = new File("C:\\Users\\Richa Singh\\Downloads\\simple-app-starter\\test-files\\normal.csv");
        // validate file
        if (!file.canWrite()) {
            //model.addAttribute("message", "Please select a CSV file to upload.");
            //model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(FileUtils.openInputStream(file)))) {

                // create csv bean reader
                CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

                // convert `CsvToBean` object to list of users
                return csvToBean.parse();
            } catch (Exception ex) {
                //model.addAttribute("message", "An error occurred while processing the CSV file.");
                //model.addAttribute("status", false);
            }
        }
        return null;
    }

    public Response getDuplicates(List<User> userList) {
        List<User> dupeList = new ArrayList<>();
        List<User> cleanList = new ArrayList<>();
        for (User user : userList) {
            if (dupeList.contains(user)) {
                continue;
            }
            List<User> dupes = new ArrayList<>();
            for (User userOther : userList) {
                if (isDuplicate(user, userOther)) {
                    dupes.add(userOther);
                }
            }
            if (!dupes.isEmpty()) {
                dupeList.add(user);
                dupeList.addAll(dupes);
            } else {
                cleanList.add(user);
            }
        }
        return new Response(dupeList, cleanList);
    }

    private boolean isDuplicate(User user, User userOther) {
        if (user.equals(userOther)) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getFirstName(), userOther.getFirstName())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getLastName(), userOther.getLastName())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getCity(), userOther.getCity())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getCompany(), userOther.getCompany())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getAddress1(), userOther.getAddress1())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getEmail(), userOther.getEmail())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getAddress2(), userOther.getAddress2())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getZip(), userOther.getZip())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getStateLong(), userOther.getStateLong())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getState(), userOther.getState())) {
            return false;
        }

        if (!isLevenshteinAcceptable(user.getPhone(), userOther.getPhone())) {
            return false;
        }

        return true;
    }

    private boolean isLevenshteinAcceptable(String a, String b) {
        return new NormalizedLevenshtein().similarity(a, b) * 100 > 70;
    }
}
