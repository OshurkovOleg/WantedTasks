package ru.wanted.WantedTask;

import java.util.Calendar;
import java.util.Date;

public class Task1 {

    public Date getNearestShippingDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Месяцы начинаются с 0
        int[] daysDispatch = {1, 10, 20};
        Date nextDay = null;

        for (int dayDispatch : daysDispatch) {
            calendar.set(year, month, dayDispatch, 18, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date availableShippingDay = new Date(calendar.getTimeInMillis());

            if (availableShippingDay.after(date)) {
                Date workDate = getWorkDay(availableShippingDay);
                if (workDate != null) {
                    nextDay = workDate;
                    break;
                }
            }
        }

        if (nextDay == null) {
            calendar.set(year, month + 1, daysDispatch[0], 18, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date availableShippingDay = new Date(calendar.getTimeInMillis());
            nextDay = getWorkDay(availableShippingDay);
        }
        return nextDay;
    }

    public Date getWorkDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayWeek == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1); // Пятница
        } else if (dayWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -2); // Пятница
        }
        return new Date(calendar.getTimeInMillis());
    }
}
