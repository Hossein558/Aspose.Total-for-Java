package com.example;

public class AsposeLicenseTester {

    public static void main(String[] args) {
        // نام دقیق فایل لایسنس بر اساس خروجی مسیر شما
        String licensePath = "Aspose.TotalforJava.lic";
        if (new java.io.File(licensePath).exists()) {
            licensePath = new java.io.File(licensePath).getAbsolutePath();
        }
        
        String[] asposeLicenseClasses = {
            "com.aspose.threed.License",
            "com.aspose.barcode.License",
            "com.aspose.cad.License",
            "com.aspose.cells.License",
            "com.aspose.diagram.License",
            "com.aspose.drawing.License",
            "com.aspose.email.License",
            "com.aspose.font.License",
            "com.aspose.html.License",
            "com.aspose.imaging.License",
            "com.aspose.note.License",
            "com.aspose.ocr.License",
            "com.aspose.omr.License",
            "com.aspose.page.License",
            "com.aspose.pdf.License",
            "com.aspose.psd.License",
            "com.aspose.pub.License",
            "com.aspose.slides.License",
            "com.aspose.tasks.License",
            "com.aspose.tex.License",
            "com.aspose.words.License",
            "com.aspose.zip.License"
        };

        System.out.println("Starting License Verification for Aspose.Total...");
        System.out.println("==================================================");

        int successCount = 0;
        int failCount = 0;

        for (String className : asposeLicenseClasses) {
            try {
                Class<?> licenseClass = Class.forName(className);
                Object licenseInstance = licenseClass.getDeclaredConstructor().newInstance();
                
                licenseClass.getMethod("setLicense", String.class).invoke(licenseInstance, licensePath);
                
                System.out.println("✅ SUCCESS : " + className);
                successCount++;
                
            } catch (ClassNotFoundException e) {
                System.out.println("⚠️ NOT FOUND : " + className + " (ممکن است نام پکیج متفاوت باشد)");
                failCount++;
            } catch (Exception e) {
                System.out.println("❌ FAILED : " + className + " -> " + e.getCause().getMessage());
                failCount++;
            }
        }

        System.out.println("==================================================");
        System.out.println("Total Tested: " + asposeLicenseClasses.length);
        System.out.println("Successfully Licensed: " + successCount);
        System.out.println("Failed / Not Found: " + failCount);
    }
}
