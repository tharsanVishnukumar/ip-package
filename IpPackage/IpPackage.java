//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package IpPackage;

public class IpPackage {
    private int octet1;
    private int octet2;
    private int octet3;
    private int octet4;

    private IpPackage(int octet1, int octet2, int octet3, int octet4) {
        this.octet1 = octet1;
        this.octet2 = octet2;
        this.octet3 = octet3;
        this.octet4 = octet4;
    }

    public void test() {
        System.out.println("Hello World Package OK ? ");
    }

    public static IpPackage getInstance(int octet1, int octet2, int octet3, int octet4) {
        try {
            if (octet1 < 0 || octet1 > 255 || octet2 < 0 || octet2 > 255 || octet3 < 0 || octet3 > 255 || octet4 < 0 || octet4 > 255) {
                throw new Exception();
            }
        } catch (Exception var5) {
            System.out.println("Valeur impossible \n");
        }

        System.out.println("o1 = " + octet1);
        System.out.println("o2 = " + octet2);
        System.out.println("o3 = " + octet3);
        System.out.println("o4 = " + octet4);
        return new IpPackage(octet1, octet2, octet3, octet4);
    }

    public String ToString() {
        return "o1 = " + this.octet1 + " o2 = " + this.octet2 + " o3 = " + this.octet3 + " o4 = " + this.octet4;
    }

    public int getOctet1() {
        return this.octet1;
    }

    public int getOctet2() {
        return this.octet2;
    }

    public int getOctet3() {
        return this.octet3;
    }

    public int getOctet4() {
        return this.octet4;
    }

    public char getClasse() {
        char var1 = 'x';
        if (this.octet1 <= 126) {
            var1 = 'A';
        }

        if (this.octet1 >= 126 && this.octet1 <= 191) {
            var1 = 'B';
        }

        if (this.octet1 >= 192 && this.octet1 <= 223) {
            var1 = 'C';
        }

        return var1;
    }

    public IpPackage adresseReseau() {
        int octet1 = this.octet1;
        int octet2 = 0;
        int octet3 = 0;
        byte octet4 = 0;
        if (this.getClasse() == 'B') {
            octet2 = this.octet2;
        }

        if (this.getClasse() == 'C') {
            octet2 = this.octet2;
            octet3 = this.octet3;
        }

        return new IpPackage(octet1, octet2, octet3, octet4);
    }

    public Boolean estMemeReseau(IpPackage ipPackage) {
        return this.adresseReseau().octet1 == ipPackage.adresseReseau().octet1 && this.adresseReseau().octet2 == ipPackage.adresseReseau().octet2 && this.adresseReseau().octet3 == ipPackage.adresseReseau().octet3;
    }
}
