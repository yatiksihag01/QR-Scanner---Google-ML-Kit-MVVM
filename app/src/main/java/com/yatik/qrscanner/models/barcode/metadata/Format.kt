/*
 * Copyright 2024 Yatik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yatik.qrscanner.models.barcode.metadata

/**
 * Represents various barcode and QR code formats.
 */
enum class Format {
    /**
     * Represents an unknown or unrecognized format.
     */
    UNKNOWN,

    /**
     * Represents the QR code format, widely used for storing information in a two-dimensional barcode.
     */
    QR_CODE,

    /**
     * Represents the EAN-13 format, primarily used for product identification.
     */
    EAN_13,

    /**
     * Represents the EAN-8 format, similar to EAN-13 but with fewer digits, often used for smaller products.
     */
    EAN_8,

    /**
     * Represents the UPC-A format, commonly used for product identification in North America.
     */
    UPC_A,

    /**
     * Represents the UPC-E format, a compressed version of UPC-A used for smaller packages.
     */
    UPC_E,

    /**
     * Represents the Code 39 format, a popular alphanumeric barcode used in various industries.
     */
    CODE_39,

    /**
     * Represents the Code 93 format, an improvement over Code 39 with higher data density.
     */
    CODE_93,

    /**
     * Represents the Code 128 format, a high-density barcode capable of encoding large amounts of data.
     */
    CODE_128,

    /**
     * Represents the PDF417 format, a two-dimensional barcode capable of encoding large amounts of data.
     */
    PDF417,

    /**
     * Represents the Data Matrix format, a two-dimensional barcode suitable for encoding small amounts of data.
     */
    DATA_MATRIX,

    /**
     * Represents the Aztec Code format, a two-dimensional barcode primarily used for high-density encoding.
     */
    AZTEC,

    /**
     * Represents the Interleaved 2 of 5 (ITF) format, commonly used in logistics and transportation for encoding numeric data.
     */
    ITF,

    /**
     * Represents the Codabar format, a discrete, self-checking barcode used in libraries, blood banks, and more.
     */
    CODABAR
}