package com.example.laborrequestingapp;

public class Jobs {
    private String name;
    private String job_description;
    private String description;
    private int icon;

    public Jobs(String name, String job_description, String description, int icon) {
        this.name = name;
        this.job_description = job_description;
        this.description = description;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getJob_description() {
        return job_description;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }
}
