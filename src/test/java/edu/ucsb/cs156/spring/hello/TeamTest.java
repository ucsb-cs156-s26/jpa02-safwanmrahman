package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void different_class() {
        assertEquals(false, team.equals("different team"));
    }

    @Test
    public void same_name_same_members() {
        Team t1 = new Team("team");
        Team t2 = new Team("team");
        t1.addMember("Alice");
        t2.addMember("Alice");
        assertEquals(true, t1.equals(t2));
    }

    @Test
    public void same_name_diff_members() {
        Team t1 = new Team("team");
        Team t2 = new Team("team");
        t1.addMember("Alice");
        t2.addMember("Bob");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void different_name() {
        Team t1 = new Team("team1");
        Team t2 = new Team("team2");
        t1.addMember("Alice");
        t2.addMember("Alice");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void hash_equals() {
        Team t = new Team("team");
        int result = t.hashCode();
        int expectedResult = 3555933;
        assertEquals(expectedResult, result);
    }

}
