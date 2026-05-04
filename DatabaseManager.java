/*
 * The DatabaseManager class handles all SQLite database operations
 * for the Time Management application.
 *
 * This class is responsible for:
 * - Creating the database table if it does not exist
 * - Saving schedule data to the database
 * - Loading the most recently saved schedule
 *
 * It acts as the persistence layer in the MVC architecture,
 * separating database logic from controllers and models.
 *
 * The database stores daily schedule entries including:
 * sleep, study, work, exercise, and leisure hours.
 *
 * Each record represents one complete 24-hour schedule entry.
 *
 * The database used is SQLite and is stored locally in a file
 * named "schedule.db".
 */
import java.sql.*;

public class DatabaseManager
{
    private static final String URL = "jdbc:sqlite:schedule.db";

    public static void init()
    {
        String sql =
            "CREATE TABLE IF NOT EXISTS schedules (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "sleep REAL," +
            "study REAL," +
            "work REAL," +
            "exercise REAL," +
            "leisure REAL)";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void saveData(ScheduleModel m)
    {
        String sql =
            "INSERT INTO schedules(sleep,study,work,exercise,leisure) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setDouble(1, m.getSleep());
            ps.setDouble(2, m.getStudy());
            ps.setDouble(3, m.getWork());
            ps.setDouble(4, m.getExercise());
            ps.setDouble(5, m.getLeisure());

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static ScheduleModel loadLatest()
    {
        String sql = "SELECT * FROM schedules ORDER BY id DESC LIMIT 1";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            if(rs.next())
            {
                return new ScheduleModel(
                    rs.getDouble("sleep"),
                    rs.getDouble("study"),
                    rs.getDouble("work"),
                    rs.getDouble("exercise"),
                    rs.getDouble("leisure")
                );
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}