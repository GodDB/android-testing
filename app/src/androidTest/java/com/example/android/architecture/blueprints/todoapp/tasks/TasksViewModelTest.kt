package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTaskRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest1 {

    private lateinit var tasksRepository: FakeTaskRepository
    private lateinit var tasksViewModel : TasksViewModel

    @Before
    fun before() {
        tasksRepository = FakeTaskRepository()
        val task1 = Task("Title1", "Description1")
        val task2 = Task("Title2", "Description2", true)
        val task3 = Task("Title3", "Description3", true)
        tasksRepository.addTasks(task1, task2, task3)

        tasksViewModel = TasksViewModel(tasksRepository)
    }
}