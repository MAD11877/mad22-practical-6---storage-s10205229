package sg.edu.np.mad.madpractical;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String _name, String _description, int _id, boolean _followed){
        name = _name;
        description = _description;
        id = _id;
        followed = _followed;

    }

    public User(){}

}

