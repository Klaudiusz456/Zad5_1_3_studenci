import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    static String FILE = "db.txt";

    static void save(Student s) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE, true);
            fw.write(s.getName() + ";" + s.getAge() + ";" + s.getBirthDate() + "\n");
        } catch (IOException e) {
            System.out.println("Błąd zapisu");
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {}
            }
        }
    }

    static List<Student> load() {
        List<Student> list = new ArrayList<Student>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 3) {
                    list.add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
        }
        return list;
    }

    static Student findStudentByName(String name) {
        List<Student> students = load();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    static boolean updateStudentAge(String name, int newAge) {
        List<Student> students = load();
        boolean updated = false;
        
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.setAge(newAge);
                updated = true;
                break;
            }
        }
        
        if (updated) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(FILE, false);
                for (Student s : students) {
                    fw.write(s.getName() + ";" + s.getAge() + ";" + s.getBirthDate() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Błąd zapisu podczas aktualizacji");
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {}
                }
            }
        }
        return updated;
    }

    static boolean deleteStudentByName(String name) {
        List<Student> students = load();
        boolean removed = false;
        List<Student> toKeep = new ArrayList<Student>();
        
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                removed = true;
            } else {
                toKeep.add(s);
            }
        }
        
        if (removed) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(FILE, false);
                for (Student s : toKeep) {
                    fw.write(s.getName() + ";" + s.getAge() + ";" + s.getBirthDate() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Błąd zapisu podczas usuwania");
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {}
                }
            }
        }
        return removed;
    }
}
