package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class JobTest {

    Job aJob;
    Job anotherJob;
    Job bigJob;

    @Before
    public void setup() {
        aJob = new Job();
        anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        bigJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

}
