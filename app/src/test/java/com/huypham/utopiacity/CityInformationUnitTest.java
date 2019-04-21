package com.huypham.utopiacity;

import com.huypham.utopiacity.data.database.DatabaseAccess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class CityInformationUnitTest {
    @Mock
    private DatabaseAccess mDatabaseAccess;

    @Test
    public void countTotalRecord() {
        Mockito.when(mDatabaseAccess.getTotalRecord()).thenReturn(272128);
        Assert.assertEquals(String.valueOf(mDatabaseAccess.getTotalRecord()), String.valueOf(272128));
        System.out.println(String.valueOf(mDatabaseAccess.getTotalRecord()));
    }
}
