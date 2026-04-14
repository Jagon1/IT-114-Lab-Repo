class Contact {
    //TODO: Create fields
    private String name;
    private String email;
    private String phone;
    //Create constructor
    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    //Add getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String toString() {
        //TODO: Return formatted string.
        return "FOUND: Name: " + name + " | email: " + email + " | phone: " + phone + "";
    }
}