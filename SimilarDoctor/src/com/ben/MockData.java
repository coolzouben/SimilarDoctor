package com.ben;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 11/3/16.
 */
public class MockData {


    public static Doctor getDoctorA() {
        return new Doctor("A", "New York", getListA(), 5.0);
    }
    public static Doctor getDoctorB() {
        return new Doctor("B", "New York", getListB(), 5.0);
    }
    public static Doctor getDoctorC() {
        return new Doctor("C", "New York", getListC(), 5.0);
    }
    public static Doctor getDoctorD() {
        return new Doctor("D", "San Francisco", getListD(), 2.0);
    }
    public static Doctor getDoctorE() {
        return new Doctor("E", "San Francisco", getListE(), 2.0);
    }
    public static Doctor getDoctorF() {
        return new Doctor("F", "Los Angeles", getListF(), 4.0);
    }
    public static Doctor getDoctorG() {
        return new Doctor("G", "New York", getListG(), 5.0);
    }
    public static Doctor getDoctorH() {
        return new Doctor("H", "San Francisco", getListH(), 3.0);
    }

    public static List<String> getListA() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        return list;
    }
    public static List<String> getListB() {
        List<String> list = new ArrayList<>();
        list.add("E");
        list.add("B");
        list.add("C");
        list.add("D");
        return list;
    }
    public static List<String> getListC() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("E");
        return list;
    }
    public static List<String> getListD() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("D");
        return list;
    }
    public static List<String> getListE() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        return list;
    }
    public static List<String> getListF() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        return list;
    }
    public static List<String> getListG() {
        List<String> list = new ArrayList<>();
        list.add("E");
        return list;
    }
    public static List<String> getListH() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("D");
        return list;
    }

    public static List<Doctor> getDoctors() {
        List<Doctor> list = new ArrayList<>();
        list.add(getDoctorA());
        list.add(getDoctorB());
        list.add(getDoctorC());
        list.add(getDoctorD());
        list.add(getDoctorE());
        list.add(getDoctorF());
        list.add(getDoctorG());
        list.add(getDoctorH());
        return list;
    }
}
