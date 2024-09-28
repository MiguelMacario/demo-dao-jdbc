package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list){
            System.out.println(s);
        }

        System.out.println("\n=== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller s : list){
            System.out.println(s);
        }

        System.out.println("\n=== TEST 4: seller Insert ====");
        Seller newSeller = new Seller(null, "Greg","greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller Update ====");
        seller = sellerDao.findById(3);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 6: seller Delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 7: department findById ====");
        Department dep = departmentDao.findById(2);

        System.out.println(dep);

        System.out.println("\n=== TEST 8: department findAll ====");
        List<Department> departments = departmentDao.findAll();
        for (Department s : departments){
            System.out.println(s);
        }

        System.out.println("\n=== TEST 9: department Insert ====");
        Department newDepartment = new Department(null, "Gatronomy");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 10: department Update ====");
        dep = departmentDao.findById(1);
        dep.setName("Law");
        departmentDao.update(dep);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 10: department Delete ====");
        System.out.print("Enter id for delete test: ");
        id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();

    }

}
