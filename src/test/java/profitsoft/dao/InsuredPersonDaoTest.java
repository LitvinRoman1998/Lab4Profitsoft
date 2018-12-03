package profitsoft.dao;

import org.junit.Assert;
import org.junit.Test;
import profitsoft.data.InsuredPerson;

import java.time.LocalDate;

public class InsuredPersonDaoTest {
    @Test
    public void readTest(){
        InsuredPerson insuredPerson1 = new InsuredPerson();
        InsuredPerson insuredPerson2 = new InsuredPerson();

        insuredPerson1.setLastName("Litvin");
        insuredPerson1.setFirstName("Roman");
        insuredPerson1.setPatronimic("Mihailovich");
        insuredPerson1.setBirthDay(LocalDate.of(1998, 6, 10));
        insuredPerson1.setInsurancePrice(100000);
        insuredPerson1.setTaxIdentificationNumber(123456789);
        InsuredPersonDao insuredPersonDao=new InsuredPersonDao();
        insuredPersonDao.create(insuredPerson1);
        int id=insuredPersonDao.getLastInsertedId();
        insuredPerson2=insuredPersonDao.read(id);
        Assert.assertEquals(insuredPerson1,insuredPerson2);
    }

    @Test
    public void updateTest(){
        InsuredPerson insuredPerson1 = new InsuredPerson();
        InsuredPerson insuredPerson2 = new InsuredPerson();
        InsuredPersonDao insuredPersonDao=new InsuredPersonDao();

        insuredPerson2.setLastName("Milo");
        insuredPerson2.setFirstName("Gaines");
        insuredPerson2.setBirthDay(LocalDate.of(1968, 3, 27));
        insuredPerson2.setInsurancePrice(10000);
        insuredPerson2.setTaxIdentificationNumber(234567891);

        insuredPersonDao.create(insuredPerson2);
        int id=insuredPersonDao.getLastInsertedId();
        insuredPerson2.setInsuredPersonId(id);
        insuredPerson2.setInsurancePrice(100000);
        insuredPersonDao.update(insuredPerson2);
        insuredPerson1=insuredPersonDao.read(id);
        Assert.assertEquals(insuredPerson2,insuredPerson1);
    }
}
