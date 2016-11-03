package com.ben;

import org.junit.Test;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 11/3/16.
 */
public class TestSimilarDoctor {


    @Test
    public void testGetDistance() {
        String area1 = "New York";
        String area2 = "San Francisco";
        DoctorSelection doctorSelection = new DoctorSelection();
        assert(Math.sqrt(10.0 * 10.0 + 10.0 * 10.0) - doctorSelection.getDistance(area1, area2) == 0);
    }

    @Test
    public void testGetCommonSpecialty() {
        Doctor dA = MockData.getDoctorA();
        Doctor dB = MockData.getDoctorB();
        DoctorSelection doctorSelection = new DoctorSelection();
        assert(doctorSelection.getCommonSpecialtyNum(dA, dB) == 3);
    }

    //this is to test the searching result when given doctor A. From the calculation I made, the result should be AEFBCHD
    @Test
    public void testSelection() {
        List<Doctor> doctors = MockData.getDoctors();
        DoctorSelection doctorSelection = new DoctorSelection();
        List<Doctor> ans = doctorSelection.selection(MockData.getDoctorA(), MockData.getDoctors());
        StringBuffer sb = new StringBuffer();
        for(Doctor doctor : ans) {
            sb.append(doctor.name);
        }
        assert (sb.toString().equals("AEFBCHD"));
    }

}
