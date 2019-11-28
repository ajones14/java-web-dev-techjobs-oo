package org.launchcode.techjobs_oo.Tests;

import com.sun.jdi.LocalVariable;
import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class JobTest {

    private Job aJob;
    private Job anotherJob;
    private Job bigJob;
    private Job oneEmptyFieldJob;

    @Before
    public void setup() {
        aJob = new Job();
        anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        bigJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        oneEmptyFieldJob = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertFalse(aJob.getId() == anotherJob.getId());
        assertTrue(abs(aJob.getId() - anotherJob.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertSame("Product tester", bigJob.getName());
        assertTrue(bigJob.getEmployer() instanceof Employer);
        assertSame("ACME", bigJob.getEmployer().getValue());
        assertTrue(bigJob.getLocation() instanceof Location);
        assertSame("Desert", bigJob.getLocation().getValue());
        assertTrue(bigJob.getPositionType() instanceof PositionType);
        assertSame("Quality control", bigJob.getPositionType().getValue());
        assertTrue(bigJob.getCoreCompetency() instanceof CoreCompetency);
        assertSame("Persistence", bigJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(anotherJob.equals(bigJob));
    }

    @Test
    public void testJobsToStringForBeginningAndEndingNewLine() {
        assertTrue(bigJob.toString().startsWith("\n"));
        assertTrue(bigJob.toString().endsWith("\n"));
    }

    @Test
    public void testForEachJobField() {
        assertTrue(bigJob.toString().contains("\nID:"));
        assertTrue(bigJob.toString().contains("\nName:"));
        assertTrue(bigJob.toString().contains("\nEmployer:"));
        assertTrue(bigJob.toString().contains("\nLocation:"));
        assertTrue(bigJob.toString().contains("\nPosition Type:"));
        assertTrue(bigJob.toString().contains("\nCore Competency:"));
    }

    @Test
    public void testToStringForEmptyField() {
        assertTrue(oneEmptyFieldJob.toString().contains("Data not found"));
    }

}
