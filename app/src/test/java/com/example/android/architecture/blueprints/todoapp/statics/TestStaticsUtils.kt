package com.example.android.architecture.blueprints.todoapp.statics

import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.statistics.getActiveAndCompletedStats
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals
import kotlin.test.assertFails

@RunWith(JUnit4::class)
class TestStaticsUtils {

    @Test
    fun 태스크_1개_일때_태스크_완료가_아닌_상태를_검증한다() {
        //given
        val task = listOf<Task>(Task("title", "desc", isCompleted = false))

        //when
        val result = getActiveAndCompletedStats(task)

        //then
        assertEquals(result.activeTasksPercent, 100f)
        assertEquals(result.completedTasksPercent, 0f)
    }

    @Test
    fun 태스크_1개_일때_태스크_완료_상태를_검증한다() {
        //given
        val task = listOf<Task>(Task("title", "desc", isCompleted = true))

        //when
        val result = getActiveAndCompletedStats(task)

        //then
        assertEquals(result.completedTasksPercent, 100f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun 태스크_4개_일때_태스크_1개_완료_상태를_검증한다() {
        //given
        val task = listOf<Task>(
            Task("title", "desc", false),
            Task("title", "desc", false),
            Task("title", "desc", false),
            Task("title", "desc", true)
        )

        //when
        val result = getActiveAndCompletedStats(task)

        //then
        assertEquals(result.completedTasksPercent, 25f)
        assertEquals(result.activeTasksPercent, 75f)
    }

    @Test
    fun 태스크가_없을때_태스크_완료상태를_검증한다() {
        //given
        val task = null

        //when
        val result = getActiveAndCompletedStats(task)

        //then
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals(result.completedTasksPercent, 0f)
    }
}