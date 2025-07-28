import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Tinh tien dien cuoi thang");
        System.out.println("2. Tinh tien taxi cuoi thang (gia su: di 1 lan/thang)");
        System.out.println("3. Tinh tien luong cuoi thang (gia su: thue = 15%)");
        System.out.println("4. Tinh tong thu nhap sau khi chi tieu cuoi thang");
        System.out.println("-------------------------------------------------");
        System.out.println("Moi ban chon chuc nang [1->4] hoac nhan phim khac de thoat:");
    }

    public static double nhapGiaTri(String message) {
        double value;
        while (true) {
            System.out.print(message + ": ");
            try {
                value = Double.parseDouble(scanner.next());
                if (value < 0) {
                    System.out.println("Vui long nhap gia tri duong");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai.");
            }
        }

        return value;
    }

    public static void tinhTienDien() {
        double kwh = nhapGiaTri("Nhap so kWh tieu thu");
        double gia = nhapGiaTri("Nhap gia tren 1 kWh");
        double tong = kwh * gia;
        System.out.println("Tien dien cuoi thang cua ban la: " + tong + " VND");
    }

    public static void tinhTienTaxi() {
        double km = nhapGiaTri("Nhap so km da di taxi");
        double gia = nhapGiaTri("Nhap gia tren 1 km");
        double tong = km * gia;
        System.out.println("Tien taxi cuoi thang cua ban la: " + tong + " VND");
    }

    public static void tinhLuongSauThue() {
        double luong = nhapGiaTri("Nhap tong luong truoc khi tru thue");
        double luongSauThue = luong * 0.85;
        System.out.println("Tien luong sau khi tru 15% thue la: " + luongSauThue + " VND");
    }

    public static void tinhThuNhapSauChiTieu() {
        double luong = nhapGiaTri("Nhap luong truoc khi tru thue");
        double tienDien = nhapGiaTri("Nhap tong tien dien");
        double tienTaxi = nhapGiaTri("Nhap tong tien taxi");
        double conLai = luong * 0.85 - (tienDien + tienTaxi);
        System.out.println("Thu nhap con lai sau khi chi tieu cuoi thang la: " + conLai + " VND");
    }

    public static void main(String[] args) {
        int option;

        do {
            menu();

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    tinhTienDien();
                    break;
                case 2:
                    tinhTienTaxi();
                    break;
                case 3:
                    tinhLuongSauThue();
                    break;
                case 4:
                    tinhThuNhapSauChiTieu();
                    break;
                default:
                    System.out.println("Cam on ban da su dung dich vu.");
            }
        } while (option >= 1 && option <= 4);

        scanner.close();
    }
}
