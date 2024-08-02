package com.example.myproject.Repository

import com.example.myproject.Model.JobModel

class MainRepository {
    val location= listOf("LosAngles,USA","NewYork,Usa")
    val category=listOf("all","Accountant","programmer","Write")

    val exampleText: String = "We are searching for a talented and motivated this job to join our growing team. In this role, you will be responsible for this job and will be responsible for this job."

    val items = listOf(
        JobModel(
            title = "UI Designer",
            company = "MicroSoft",
            picURL = "logo1",
            time = "Full-Time",
            model = "Remote",
            level = "Internship",
            location = "NewYork, USA",
            salary = "\$38k ~ \$46K",
            category = "2",
            about = exampleText,
            description = exampleText
        ),
        JobModel(
            title = "Accountants",
            company = "KianSoft",
            picURL = "logo2",
            time = "Part-Time",
            model = "Remote",
            level = "In person",
            location = "LosAngles, USA",
            salary = "\$26k ~ \$36K",
            category = "1",
            about = exampleText,
            description = exampleText
        ),
        JobModel(
            title = "The author of the news",
            company = "MakanSoft",
            picURL = "logo3",
            time = "Part-Time",
            model = "Remote",
            level = "Seniur Level",
            location = "NewYork, USA",
            salary = "\$20k ~ \$23K",
            category = "3",
            about = exampleText,
            description = exampleText
        ),
        JobModel(
            title = "Kotlin Programmer",
            company = "TestSoft",
            picURL = "logo4",
            time = "Full-Time",
            model = "Remote",
            level = "Internship",
            location = "LosAngles, USA",
            salary = "\$38k ~ \$40K",
            category = "2",
            about = exampleText,
            description = exampleText
        )
    )

}