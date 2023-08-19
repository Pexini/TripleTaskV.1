package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void searchAndFindInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
                Assertions.assertTrue(simpleTask.matches("родителям"));
    }
   @Test
    public void searchAndNotFoundInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertFalse(simpleTask.matches("снег"));
    }
    @Test
    public void searchAndFindInEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Assertions.assertTrue(epic.matches("Яйца"));
    }
    @Test
    public void searchAndNotFoundInEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Assertions.assertFalse(epic.matches("Утро"));
    }
    @Test
    public void searchAndFindInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("НетоБанка"));
    }
    @Test
    public void searchAndNotFindInMeetingInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("Выкатка"));
    }
    @Test
    public void searchAndFindInMeetingInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("НетоБанка"));
    }
    @Test
    public void searchAndNotFoundInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertFalse(meeting.matches("Океан"));
    }
}