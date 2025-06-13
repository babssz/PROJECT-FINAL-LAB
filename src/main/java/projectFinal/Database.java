package projectFinal;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<Properti> propertiRiilList = new ArrayList<>();

    static {
        propertiRiilList.add(new PropertiRiil(
                "PR001",
                "Jl. Boulevard, Kompleks Panakkukang Mas",
                "Makassar",
                1_200_000_000L,
                150,
                160,
                4,
                3,
                "/assets/home1.jpg",
                "Andi Property",
                "081234567890"));

        propertiRiilList.add(new PropertiRiil(
                "PR002",
                "Jl. Poros BTP, Ruko Biringkanaya",
                "Makassar",
                850_000_000L,
                200,
                100,
                0,
                3,
                "/assets/home2.jpg",
                "Citra Agen",
                "08111222333"));

        propertiRiilList.add(new PropertiRiil(
                "PR003",
                "Jl. Perintis Kemerdekaan KM. 9, Tamalanrea",
                "Makassar",
                600_000_000L,
                80,
                90,
                3,
                2,
                "/assets/home3.jpg",
                "Budi Propertindo",
                "08555444333"));
    }

    public static List<Properti> getPropertiRiilList() {
        return propertiRiilList;
    }
}