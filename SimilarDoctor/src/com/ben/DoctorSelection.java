package com.ben;

import java.util.*;

/**
 * Created by Ben on 11/2/16.
 */

class Doctor {
    String name;
    String area;
    List<String> specialty;
    double score;

    public Doctor(String name, String area, List<String> specialty, double score) {
        this.name = name;
        this.area = area;
        this.specialty = specialty;
        this.score = score;
    }
}


public class DoctorSelection {

    //empty constructor
    public DoctorSelection(){};

    /**
     *
     * @param area1
     * @param area2
     * @return the distance between a and b
     * Calculate the distance between a and b according to the longitude and latitude.
     * To simplify this problem, we assume that all the areas are on a plane and all the longitude and latitude
     * can be gained by other methods(like google map).
     */
    private double distance(String area1, String area2) {
        double[] aCoordinate = getCoordinate(area1);
        double[] bCoordinate = getCoordinate(area2);
        return Math.sqrt((aCoordinate[0] - bCoordinate[0]) * (aCoordinate[0] - bCoordinate[0])
                + (aCoordinate[1] - bCoordinate[1]) * (aCoordinate[1] - bCoordinate[1]));
    }

    public double getDistance(String area1, String area2) {
        return distance(area1, area2);
    }

    /**
     *
     * @param area
     * @return
     *
     * test data for the longitude and latitude of all areas
     * For convenience, I use some simple example here to get the 'virtual' coordinate
     */
    private double[] getCoordinate(String area) {
        switch (area) {
            case "San Francisco":
                return new double[]{0.0, 0.0};
            case "Los Angeles" :
                return new double[]{1.0, 1.0};
            case "New York" :
                return new double[]{10.0, -10.0};
            default :
                return null;
        }
    }


    /**
     *
     * @param doctor given doctor
     * @param doctors the directory of all the doctors
     * @return
     * in my opinion, The 1st criteria for 'similar' is the number of common specialty(at least one common specialty),
     * of course, the more the better.
     * Following criteria should be area and then score.
     * And the displaying order also need meet the above standard.
     * For example, Given doctor A, B has 2 common specialties but C has only 1. B should be followed by C.
     *              Given doctor A, B and C both have 2 common specialties, but B's area is closer to A than C. B should be followed by C.
     *              Given doctor A, B and C both have 2 common specialties and the same area, but B's score is higher than C. B should be followed by C.
     *
     */
    public List<Doctor> selection(Doctor doctor, List<Doctor> doctors) {
        List<Doctor> doctorList = new ArrayList<>();
        HashMap<Doctor, Integer> map = new HashMap<>();
        for(Doctor candidate : doctors) {
            if(hasCommonSpecialty(candidate, doctor) > 0) {
                doctorList.add(candidate);
                //record the # of common specialty
                map.put(candidate, hasCommonSpecialty(candidate, doctor));
            }
        }
        Collections.sort(doctorList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                if(map.get(o1) == map.get(o2)) {
                    if(distance(o1.area, doctor.area) == distance(o2.area, doctor.area)) {
                        if(o1.score == o2.score) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o1.score > o2.score ? -1 : 1;
                    }
                    return distance(o1.area, doctor.area)  < distance(o2.area, doctor.area) ? -1 : 1;
                }
                return map.get(o2) - map.get(o1);
            }
        });
        return doctorList;
    }


    /**
     *
     * @param d1
     * @param d2
     * @return number of common specialty
     */
    private int hasCommonSpecialty(Doctor d1, Doctor d2) {
        HashSet<String> set = new HashSet<>();
        int num = 0;
        for(String s : d1.specialty) {
            set.add(s);
        }
        for(String s : d2.specialty) {
            if(set.contains(s)) num++;
        }
        return num;
    }

    public int getCommonSpecialtyNum(Doctor d1, Doctor d2) {
        return hasCommonSpecialty(d1, d2);
    }

}
