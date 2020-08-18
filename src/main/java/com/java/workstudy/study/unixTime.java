package com.java.workstudy.study;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class unixTime {
    private final static String API_OFFER = "https://open.3s.mobvista.com/channel/v5?client_key=%s&return_type=json&%s";
    private final static String CLIENT_KEY = "15039";
    private final static String CLIENT_SECRET_KEY = "FMAYWFCQ6CHGU0Y2NTJI";
    private final static String BASE_PARAM = "client_key=%s&client_secret_key=%s&return_type=json&time=%s";
    public static  void main(String[]args) throws NoSuchAlgorithmException {
        String token =  unixTime.generateTimeToken();
        System.out.println(token);
    }
    public static String generateTimeToken() {
        long unixTime = System.currentTimeMillis()/1000;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String token =  new BigInteger(1, md.digest(
                String.format(BASE_PARAM, CLIENT_KEY, CLIENT_SECRET_KEY,unixTime).getBytes())).toString(16);
        String timetoken = String.format("time=%s&token=%s",unixTime,token);
        return timetoken;
    }
}
