package com.i2i.btk.suncell;

public class UserPacketInfoModel {


        private float total;
        private float used;
        private String nameOfPacket;

        public UserPacketInfoModel(String nameOfPacket,float total, float used ) {
            this.total = total;
            this.used = used;
            this.nameOfPacket = nameOfPacket;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }

        public float getUsed() {
            return used;
        }

        public void setUsed(float used) {
            this.used = used;
        }

        public String getNameOfPacket() {
            return nameOfPacket;
        }

        public void setNameOfPacket(String nameOfPacket) {
            this.nameOfPacket = nameOfPacket;
        }

}
